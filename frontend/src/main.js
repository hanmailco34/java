import { createApp } from 'vue';
import App from './App.vue';
import PrimeVue from 'primevue/config';
import router from './router';
import globalFunc from './common/common';

const app = createApp(App);

app.config.globalProperties = globalFunc;

app.use(PrimeVue);
app.use(router);
app.mount('#app');

