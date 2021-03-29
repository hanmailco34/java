<template>
  <div class="home_container">
      {{userInfo.name}}님 환영합니다.
  </div>
</template>

<script>
import { getCurrentInstance } from 'vue'

export default {
  setup() {
    const {ctx} = getCurrentInstance();

    if(!ctx.userInfo) {         
      ctx.setUserInfo();
    }
    
  }
}
</script>

<style scoped>
@import "../assets/css/home.css";
</style>