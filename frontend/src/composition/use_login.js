import { fetchGetCall } from "@/fetch/fetch_api";

export async function checkLogin(idValue,pwdValue) {
    const pwdExp = new RegExp('^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})');
    if(pwdExp.test(pwdValue) && idValue !== '') {
        var user = await fetchGetCall('http://localhost:89/data/user.json');
        if(user.id === idValue && user.pwd === pwdValue) return {status:"OK",data:user};
        else return {status:"OOPS",msg:"not match"};
    }
    return false;
}
export function isNull(psValue)
{
	if(new String(psValue).valueof() == "undefined") {
		return true;
	}
	
	if(psValue == null){
		return true;
	}
	
	if(("x"+psValue == "xNaN") && (new String(psValue.length).valueof() == "undefined")) {
		return true;
	}
	
	if(psValue.length == 0) {
		return true;
	}
	
	return false;
}