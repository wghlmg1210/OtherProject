package myself.regex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author zl
 * 
 */
public class StationMnte {

	private String id; // 主键
	private String sid; // 站点ID
	private String MnteStarttime; // 维护开始时间
	private String MnteEndtime; // 维护结束时间
	private String MnteEffective; // 维护是否有效

	/** add by Huang 2016-03-15 */
	private String MnteUser; // 维护人
	private String MnteStatus; // 维护状态
	private String MnteContent; // 维护内容
	private String contactPhone; // 联系电话
	private String remark; // 备注

	public String getMnteStatus() {
		return MnteStatus;
	}

	public void setMnteStatus(String mnteStatus) {
		MnteStatus = mnteStatus;
	}

	public String getMnteContent() {
		return MnteContent;
	}

	public void setMnteContent(String mnteContent) {
		MnteContent = mnteContent;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getMnteStarttime() {
		return MnteStarttime;
	}

	public String getMnteEndtime() {
		return MnteEndtime;
	}

	public String getMnteEffective() {
		return MnteEffective;
	}

	public void setMnteEffective(String mnteEffective) {
		Integer.parseInt(mnteEffective);// 使用异常机制处理实参
		MnteEffective = mnteEffective;
	}

	// 2015-12-23 08:00:00
	public void setMnteStarttime(String dateStr) {
		if (dateStr.length() == 16) {
			dateStr += ":00";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			dateFormat.parse(dateStr);// 使用异常机制处理实参
			this.MnteStarttime = dateStr;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void setMnteEndtime(String durationTime) {
		if (MnteStarttime == null) {
			throw new IllegalArgumentException("起始时间未知，请先设置维护起始时间");
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		// 用于匹配维护时长
		Pattern pattern = Pattern.compile("(\\d*)(\\S*)");
		Matcher matcher = pattern.matcher(durationTime);
		if (matcher.find()) {
			String dateType = matcher.group(2);// 获取时长类型
			// 获取时长数值
			int duration = Integer.parseInt(matcher.group(1)), type = 0;
			Calendar calendar = Calendar.getInstance();
			try {
				calendar.setTime(dateFormat.parse(this.MnteStarttime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if ("分钟".equals(dateType)) {
				type = Calendar.MINUTE;
			} else if ("小时".equals(dateType)) {
				type = Calendar.HOUR;
			} else if ("天".equals(dateType)) {
				type = Calendar.DATE;
			}
			calendar.add(type, duration);
			this.MnteEndtime = dateFormat.format(calendar.getTime());
		}
	}

	/**
	 * 根据内容填写对象中的属性
	 * 
	 * @param content
	 */
	public void setInfoByContent(String content) {
		Pattern pattern = Pattern.compile("\"name\":\"([^\"]*)\",\"val\":\"([^\"]*)\"",
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(content);
		while(matcher.find()) {
			String key = matcher.group(1);
			String value = matcher.group(2);
			if("维护人".equals(key)) {
				this.setMnteUser(value);
			} else if("维护状态".equals(key)) {
				this.setMnteStatus(value);
			} else if("开始时间".equals(key)) {
				this.setMnteStarttime(value);
			} else if("维护时长".equals(key)) {
				this.setMnteEndtime(value);
			} else if("维护内容".equals(key)) {
				this.setMnteContent(value);
			} else if("联系电话".equals(key)) {
				this.setContactPhone(value);
			} else if("备注".equals(key)) {
				this.setRemark(value);
			} else if("维护数据有效".equals(key)) {
				this.setMnteEffective("是".equals(value) ? "1" : "0");
			}
		}
	}
	
	public String getMnteUser() {
		return MnteUser;
	}

	public void setMnteUser(String mnteUser) {
		MnteUser = mnteUser;
	}
}
