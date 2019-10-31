
/*
 * 字符串非空验证，非空返回true，空返回false
 */
function verifyNotNull(str) {
	return str != "";
}

/*
 * 用户名验证
 * 规则：用户名组成为字母6-20位
 */
function verifyUserName(str) {
	var reg = /^[a-zA-Z]{6,20}$/;
	return reg.test(str);
}

/**
 * 密码验证
 * 规则：密码组成为字母或数字，6-20位
 */
function verifyPwd(str){
  	var reg = /^[a-zA-Z0-9]{6,20}$/;
	return reg.test(str);
}

/**
 * 说明：验证确认密码
 * 规则：密码和确认密码相同
 */
function verifyConfirmPwd(pwd,confirmpwd){
	return confirmpwd == pwd;
}

/**
 * 说明：验证年龄
 * 规则：年龄只能是0-99岁
 */
function verifyAge(age) {
	var reg = /^[1]?[0-9]{1,2}$/;
	return reg.test(age);
}

/**
 * 说明：验证身份证号
 * 规则：最后一位可以为X
 */
function verifyID(id) {
	var reg = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/;
	return reg.test(id);
}

/**
 * 说明：验证真实姓名
 * 规则：汉字和英文都可以
 */
function verifyName(name) {
	var reg = /^[\u4E00-\u9FA5A-Za-z]+$/;
	return reg.test(name);
}

/**
 * 说明:验证手机号
 * 规则：11位数字
 */
function verifyTel(tel) {
	var reg = /^[0-9]{11}$/;
	return reg.test(tel);
}

/**
 * 说明：验证邮箱
 */
function verifyEmail(email) {
	var reg = /^[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?$/;
	return reg.test(email);
}

/**
 * 说明：验证邮政编码
 */
function verifyPostcode(postcode) {
	var reg = /^[1-9]\d{5}(?!\d)$/;
	return reg.test(postcode);
}

/**
 * 说明：验证正整数
*/
function verifyPositiveInt(num) {
	debugger;
	var reg = /^[1-9]\d*$/;
	return reg.test(num);
}

/**
 * 验证是否是正浮点数
 * @param num
 * @returns {boolean}
 */
function verifyPositiveFloat(num) {
	return /^[1-9]\d*(\.\d*)?$/.test(num)
}