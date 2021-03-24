<template>
    <div class="login_container">
        <div class="login_form">
            <div class="login_title">
                로그인
            </div>
            <div class="id_box">
                <InputText type="text" v-model="idValue" placeholder="아이디"/>
            </div>
            <div class="pwd_box">
                <Password v-model="pwdValue" placeholder="비밀번호" weakLabel="별로" mediumLabel="힘내" strongLabel="좋아" promptLabel="비밀번호를 입력하세요"/>
            </div>
            <div class="login_box">
                <Button label="로그인" @click="login"/>
            </div>
        </div>
    </div>
</template>

<script>
import InputText from 'primevue/inputtext';
import Password from 'primevue/password';
import Button from 'primevue/button';
import {ref} from 'vue';

export default {
    components: {
        InputText,
        Password,
        Button
    },
    setup() {
        const idValue = ref('');
        const pwdValue = ref('');

        const login = () => {
            console.log(idValue.value);
        }
        
        return {
            idValue,
            pwdValue,
            login
        }
    }
}
</script>

<style scoped>
@import "../assets/css/login.css";
</style>