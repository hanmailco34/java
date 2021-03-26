<template>
  <div>
      <router-view/>
  </div>  
</template>

<script>
import { getCurrentInstance } from 'vue';
import { useRouter } from 'vue-router';

export default {
  name: 'App',
  components: {
    
  },
  setup() {
    const {ctx} = getCurrentInstance();
    const checkSession = JSON.parse(localStorage.getItem('userInfo'));
    if(checkSession) {
      const sessionTime = checkSession.loginTime;
      const sessionEndTime = ctx.addTime(sessionTime,'h',1);
      if(new Date(sessionEndTime) <= new Date()) {
        localStorage.removeItem('userInfo');
        useRouter().push({
          name: 'Login'
        });
      }
      else {
        useRouter().push({
          name: 'Home'
        });
      }
    }
    else {
      useRouter().push({
        name: 'Login'
      });
    }    
  }
}
</script>

<style>
@import "~primevue/resources/themes/saga-blue/theme.css";
@import "~primeicons/primeicons.css";
*{
  margin: 0;
  padding: 0;
}
</style>
