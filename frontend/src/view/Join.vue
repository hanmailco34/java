<template>
    <div class="join_container">
        <div class="join_form">
            <div class="join_title">
                키보드 회원가입
            </div>
            <div class="id_box">
                <InputText type="text" v-model="idValue" placeholder="아이디"/>
            </div>
            <div class="name_box">
                <InputText type="text" v-model="nameValue" placeholder="이름"/>
            </div>
            <div class="pwd_box1">
                <Password v-model="pwdValue1" placeholder="비밀번호" />
            </div>
            <div class="pwd_box2">
                <Password v-model="pwdValue2" placeholder="비밀번호"  @blur="CheckPassword" />
            </div>
            <div class="email_box">
                <InputText v-model="emailValue" placeholder="이메일"/>
            </div>
            <div class="register_box">
                <Button label="회원가입"  @click="Register" class="register_width"/>
                <Button label="초기화"  @click="Clear" class="register_width"/>
            </div>
        </div>
    </div>
</template>

<script>
import InputText from 'primevue/inputtext';
import Password from 'primevue/password';
import Button from 'primevue/button';
import {ref} from 'vue';
import {isNull} from '@/composition/use_login';
export default {
    components: {
        InputText,
        Password,
        Button
    },
    setup() {
        let idValue = ref('');
        let nameValue = ref('');
        let pwdValue1 = ref('');
        let pwdValue2 = ref('');
        let emailValue = ref('');

        const CheckPassword = () => {
            if(pwdValue1.value !== pwdValue2.value){
                alert('비밀번호가 맞지 않습니다.');
            }else{
                console.log('첫번째 비밀번호:'+pwdValue1.value+',두번째 비밀번호:'+pwdValue2.value);
            }
        };
        const Clear = () => {
            idValue.value = '';
            nameValue.value = '';
            pwdValue1.value = '';
            pwdValue2.value = '';
            emailValue.value = '';
        };
        const Register = () => {
            isNull(idValue.value).then(r=>{
                if(!r){
                    alert('아이디를 입력해주세요.');
                }else{
                    alert('통과');
                }
            })
        };
        return{
            idValue,
            nameValue,
            pwdValue1,
            pwdValue2,
            emailValue,
            CheckPassword,
            Register,
            Clear
        }
    }
}
</script>

<style>
@import "../assets/css/join.css";
</style>