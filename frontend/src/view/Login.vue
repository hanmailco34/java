<template>
    <div class="login_container">
        <div class="login_form">
            <div class="login_title">
                키보드 워리어
            </div>
            <div class="id_box">
                <InputText type="text" v-model="idValue" placeholder="아이디"/>
            </div>
            <div class="pwd_box">
                <Password v-model="pwdValue" placeholder="비밀번호" weakLabel="별로" mediumLabel="힘내" strongLabel="좋아" promptLabel="비밀번호를 입력하세요" />
            </div>
            <div class="login_box">
                <Button label="로그인"  @click="Login" class="login_width"/>
            </div>
            <div class="message_box">
                <Message severity="warn" :sticky="false" :life=0 ref="message">
                    <span ref="messageTxt"></span>
                </Message>
            </div>
            <div class="join_box">
                <router-link to="join">회원가입</router-link>
            </div>
        </div>
    </div>
</template>

<script>
import InputText from 'primevue/inputtext';
import Password from 'primevue/password';
import Button from 'primevue/button';
import Message from 'primevue/message';
import {ref,getCurrentInstance} from 'vue';
import {checkLogin} from '@/composition/use_login';
import { useRouter } from 'vue-router';

export default {
    components: {
        InputText,
        Password,
        Button,
        Message
    },
    setup() {
        const idValue = ref('');
        const pwdValue = ref('');
        const message = ref('');
        const messageTxt = ref('');
        const {ctx} = getCurrentInstance();    
        const notVaildLogin = '최소 8자 이상 & 최소 1자 소문자 & 최소 1자 대문자';
        const notMatchLogin = '아이디나 비밀번호가 틀립니다.';
        const router = useRouter();  

        const Login = () => {
            checkLogin(idValue.value,pwdValue.value).then(r=>{
                if(!r) {
                    ctx.msgShow(message.value,messageTxt.value,notVaildLogin);
                }
                else {
                    if(r.status === 'OOPS') {
                        ctx.msgShow(message.value,messageTxt.value,notMatchLogin);
                    }
                    else {
                        localStorage.setItem('userInfo',`{"id":"${idValue.value}","name":"${r.data.name}","loginTime":"${new Date().toUTCString()}"}`);
                        router.push({
                            name: 'Home'
                        });
                    }
                }
            })
        }
        
        return {
            idValue,
            pwdValue,
            Login,
            message,
            messageTxt
        }
    }
}
</script>

<style scoped>
@import "../assets/css/login.css";
</style>