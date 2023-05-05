import { createRouter, createWebHashHistory } from 'vue-router'
import Layout from '@/views/Layout.vue'
import Meishi from '@/components/HeaderSecView/meishi.vue'
import Canchu from '@/components/HeaderSecView/canchu.vue'
import Dianqi from '@/components/HeaderSecView/dianqi.vue'
import Fuzhuang from '@/components/HeaderSecView/fuzhuang.vue'
import Jujia from '@/components/HeaderSecView/jujia.vue'
import Xihu from '@/components/HeaderSecView/xihu.vue'
import Yishu from '@/components/HeaderSecView/yishu.vue'
import Register from '@/views/Register.vue'
import test from '@/views/test.vue'
import Goodsinfo from '@/views/Goodsinfo.vue'
import Gouwu from '@/views/Gouwu.vue'
import Dingdan from '@/views/dingdan.vue'
const Login=()=>import('@/views/Login.vue')
const routes = [
  {
    path:'/',
    name:'Layout',
    component:Layout,
    redirect:'/Meishi',
    children: [
      {
        path:'/Meishi',
        name:'Meishi',
        component:Meishi,
      },
      {
        path:'/Canchu',
        name:'Canchu',
        component:Canchu,
      },
      {
        path:'/Dianqi',
        name:'Dianqi',
        component:Dianqi,
      },
      {
        path:'/Fuzhuang',
        name:'Fuzhuang',
        component:Fuzhuang,
      },
      {
        path:'/Jujia',
        name:'Jujia',
        component:Jujia,
      },
      {
        path:'/Xihu',
        name:'Xihu',
        component:Xihu,
      },
      {
        path:'/Yishu',
        name:'Yishu',
        component:Yishu,
      },
    ]
  },
  {
    path:'/login',
    name:'Login',
    component:Login
  },
  {
    path:'/Register',
    name:'Register',
    component:Register
  },
  {
    path:'/test',
    name:'test',
    component:test
  },
  {
    path:'/Goods/:id',
    name:'Goods',
    component:Goodsinfo
  },
  {
    path:'/Gouwu',
    name:'Gouwu',
    component:Gouwu
  },
  {
    path:'/Dingdan',
    name:'Dingdan',
    component:Dingdan
  }
]

const router = createRouter({
  //hash模式
  history: createWebHashHistory(),
  routes
})

export default router
