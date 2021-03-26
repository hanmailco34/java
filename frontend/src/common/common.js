const globalFunc = {
    msgShow: (target,txtTarget,txt) => {
        txtTarget.textContent = txt;
        target.visible = true;
        setTimeout(()=>{
            target.visible = false;
        },2000)
    },
    addTime: (targetTime,cmd,num) => {
        let target = new Date(targetTime); 
        let getTime;       
        switch(cmd) {
            case 's':
                getTime = target.getSeconds() + num;
                target = target.setSeconds(getTime);
                break;
            case 'm':
                getTime = target.getMinutes() + num;
                target = target.setMinutes(getTime);
                break;
            case 'h':
                getTime = target.getHours() + num;
                target = target.setHours(getTime);
                break;
            default:
                return new Error('잘못된 정보입니다.');
        }
        return new Date(target);
    },
    userInfo: JSON.parse(localStorage.getItem('userInfo')),

};

export default globalFunc;