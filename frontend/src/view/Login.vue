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
                <Message severity="warn" :sticky="false" :life=0 ref="message">최소 8자 이상 & 최소 1자 소문자 & 최소 1자 대문자</Message>
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
import {ref} from 'vue';
import {checkLogin} from '@/composition/use_login';

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

        const Login = () => {
            if(checkLogin(idValue.value,pwdValue.value)) {
                console.log("로그인");
            }
            else {
                message.value.visible = true;
                setTimeout(()=>{
                    message.value.visible = false;
                },2000)
            }
        }
        
        return {
            idValue,
            pwdValue,
            Login,
            message
        }
    }
}
</script>

<style scoped>
@import "../assets/css/login.css";
</style>