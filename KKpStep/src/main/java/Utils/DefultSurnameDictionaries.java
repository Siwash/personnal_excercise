package Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 * <h2>青阳龙野随机中文名生成工具-默认姓氏字典</h2>
 * <p>
 * 该类用于存储、操作姓氏字典，使用单例模式进行设计，请使用instance()方法获取其唯一实例
 * </p>
 * 
 * @author 青阳龙野(kohgylw)
 * @version 1.0
 */
public class DefultSurnameDictionaries implements SurnameDictionaries {

	private static SurnameDictionaries sd = new DefultSurnameDictionaries();
	private HashSet<String> surname_sMap;// 单姓集合
	private HashSet<String> surname_dMap;// 复姓集合
	private ArrayList<String> surname_sList;//用于操作的列表
	private ArrayList<String> surname_dList;

	private DefultSurnameDictionaries() {
		// 配置单姓列表，如需修改请在此添加或删除姓氏。
		String[] surname_s = { "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "楮", "卫", "蒋", "沈", "韩", "杨", "朱", "秦",
				"尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦",
				"章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳",
				"酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐",
				"于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹", "姚", "邵",
				"湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
				"屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闽", "席", "季", "麻", "强", "贾", "路", "娄", "危", "江", "童", "颜", "郭",
				"梅", "盛", "林", "刁", "锺", "徐", "丘", "骆", "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "支", "柯", "昝",
				"管", "卢", "莫", "经", "房", "裘", "缪", "干", "解", "应", "宗", "丁", "宣", "贲", "邓", "郁", "单", "杭", "洪", "包", "诸",
				"左", "石", "崔", "吉", "钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀", "羊", "於", "惠", "甄", "麹", "家",
				"封", "芮", "羿", "储", "靳", "汲", "邴", "糜", "松", "井", "段", "富", "巫", "乌", "焦", "巴", "弓", "牧", "隗", "山", "谷",
				"车", "侯", "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲", "伊", "宫", "宁", "仇", "栾", "暴", "甘", "斜", "厉", "戎", "祖",
				"武", "符", "刘", "景", "詹", "束", "龙", "叶", "幸", "司", "韶", "郜", "黎", "蓟", "薄", "印", "宿", "白", "怀", "蒲", "邰",
				"从", "鄂", "索", "咸", "籍", "赖", "卓", "蔺", "屠", "蒙", "池", "乔", "阴", "郁", "胥", "能", "苍", "双", "闻", "莘", "党",
				"翟", "谭", "贡", "劳", "逄", "姬", "申", "扶", "堵", "冉", "宰", "郦", "雍", "郤", "璩", "桑", "桂", "濮", "牛", "寿", "通",
				"边", "扈", "燕", "冀", "郏", "浦", "尚", "农", "温", "别", "庄", "晏", "柴", "瞿", "阎", "充", "慕", "连", "茹", "习", "宦",
				"艾", "鱼", "容", "向", "古", "易", "慎", "戈", "廖", "庾", "终", "暨", "居", "衡", "步", "都", "耿", "满", "弘", "匡", "国",
				"文", "寇", "广", "禄", "阙", "东", "欧", "殳", "沃", "利", "蔚", "越", "夔", "隆", "师", "巩", "厍", "聂", "晁", "勾", "敖",
				"融", "冷", "訾", "辛", "阚", "那", "简", "饶", "空", "曾", "毋", "沙", "乜", "养", "鞠", "须", "丰", "巢", "关", "蒯", "相",
				"查", "后", "荆", "红", "游", "竺", "权", "逑", "盖", "益", "桓", "公", "晋", "楚", "阎", "法", "汝", "鄢", "涂", "钦", "岳",
				"帅", "缑", "亢", "况", "后", "有", "琴", "商", "牟", "佘", "佴", "伯", "赏", "墨", "哈", "谯", "笪", "年", "爱", "阳", "佟",
				"归", "海", "仉", "督" };
		surname_sMap = new HashSet<>();
		surname_sMap.addAll(Arrays.asList(surname_s));
		// 默认复姓列表，同上
		String[] surname_d = { "万俟", "司马", "上官", "欧阳", "夏侯", "诸葛", "闻人", "东方", "赫连", "皇甫", "尉迟", "公羊", "澹台", "公冶", "宗政",
				"濮阳", "淳于", "单于", "太叔", "申屠", "公孙", "仲孙", "轩辕", "令狐", "锺离", "宇文", "长孙", "慕容", "鲜于", "闾丘", "司徒", "司空",
				"丌官", "司寇", "子车", "颛孙", "端木", "巫马", "公西", "漆雕", "乐正", "壤驷", "公良", "拓拔", "夹谷", "宰父", "谷梁", "段干", "百里",
				"东郭", "南门", "呼延", "羊舌", "微生", "梁丘", "左丘", "东门", "西门", "南宫" };
		surname_dMap = new HashSet<>();
		surname_dMap.addAll(Arrays.asList(surname_d));
		surname_sList=new ArrayList<>(surname_sMap);
		surname_dList=new ArrayList<>(surname_dMap);
	}

	/**
	 * <h2>获取姓氏字典唯一实例</h2>
	 * <p>
	 * 请通过该方法获取唯一实例。
	 * </p>
	 * 
	 * @author 青阳龙野(kohgylw)
	 * @param 无
	 * @return SurnameDictionaries 实例对象
	 */
	public static SurnameDictionaries instance() {
		return sd;
	}

	/**
	 * 
	 * <h2>检查当前姓氏字典中是否有某一姓氏</h2>
	 * <p>
	 * 该方法检查传入的字符串是否存在于姓氏字典中。
	 * </p>
	 * 
	 * @author 青阳龙野(kohgylw)
	 * @param testsurname
	 *            String 需要检查的姓氏字符串
	 * @return boolean 表示是否存在
	 */
	public boolean haveSurnameOf(String testsurname) {
		return surname_sMap.contains(testsurname) || surname_dMap.contains(testsurname);
	}

	/**
	 * 
	 * <h2>获取当前姓氏集合规模</h2>
	 * <p>
	 * 以int形式返回当前数据集合的规模
	 * </p>
	 * 
	 * @author 青阳龙野(kohgylw)
	 * @param 无
	 * @return int 集合规模
	 */
	public int getSurnameSetSize() {
		return surname_sMap.size() + surname_dMap.size();
	}

	/**
	 * 
	 * <h2>从姓氏字典中随机获取一个单姓</h2>
	 * <p>
	 * 该方法每次调用均会重新随机。如果姓氏集合为空，则返回一个空字符串。
	 * </p>
	 * 
	 * @author 青阳龙野(kohgylw)
	 * @param 无
	 * @return String 随机的单字姓氏
	 */
	public String getRandomSingleSurname() {
		double r = Math.random();
		int size = surname_sMap.size();
		if (size == 0) {
			return "";
		} else {
			int index = (int) (r * size);
			return surname_sList.get(index);
		}
	}

	/**
	 * 
	 * <h2>从姓氏字典中随机获取一个复姓</h2>
	 * <p>
	 * 该方法每次调用均会重新随机。如果双字姓氏字典为空，则返回一个空字符串。
	 * </p>
	 * 
	 * @author 青阳龙野(kohgylw)
	 * @param 无
	 * @return String 随机的双字姓氏
	 */
	public String getRandomDoubleSurname() {
		double r = Math.random();
		int size = surname_dMap.size();
		if (size == 0) {
			return "";
		} else {
			int index = (int) (r * size);
			return surname_dList.get(index);
		}
	}
	
	/**
	 * 
	 * <h2>得到单姓与复姓的比率</h2>
	 * <p>该方法返回复姓集合规模占姓氏总规模的比值，该值会决定姓名随机生成时使用单复姓的占比。其值应小于1。</p>
	 * @author 青阳龙野(kohgylw)
	 * @param 无
	 * @return double 比值
	 */
	public double getSingleDoubleRate() {
		// TODO 自动生成的方法存根
		return ((double)surname_dMap.size()/(double)(surname_dMap.size()+surname_sMap.size()));
	}
}
