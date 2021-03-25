import { fetchGetCall } from "@/fetch/fetch_api";

export function checkLogin(idValue,pwdValue) {
    const pwdExp = new RegExp('^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})');
    if(pwdExp.test(pwdValue) && idValue !== '') {
        var test = fetchGetCall('http://localhost:89/data/user.json');
        console.log(test);
        return true;
    }
    return false;
}