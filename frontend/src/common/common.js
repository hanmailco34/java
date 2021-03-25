const globalFunc = {
    msgShow: (target,txtTarget,txt) => {
        txtTarget.textContent = txt;
        target.visible = true;
        setTimeout(()=>{
            target.visible = false;
        },2000)
    }
};

export default globalFunc;