<template>
  <div>
      <router-view/>
  </div>  
</template>

<script>
import { useRouter } from 'vue-router';

export default {
  name: 'App',
  components: {
    
  },
  setup() {
    useRouter().push({
      name: 'Login'
    });
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
