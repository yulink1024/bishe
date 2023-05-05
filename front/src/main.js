import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import ViewUIPlus from 'view-ui-plus'
import 'view-ui-plus/dist/styles/viewuiplus.css'
//引入初始化样式
import'@/assets/styles/base.css'
createApp(App).use(store).use(router).use(ElementPlus).use(ViewUIPlus).mount('#app')
