<template>
  <topBar/>
  <Headerpar/>
  <!-- 主体区域 -->
  <!-- <div class="main">
    <router-view />
  </div> -->
  <div class="newUser" v-show="userinfor.new">
  <NewUser/>
  </div>
  <div class="userv">
    <userinforView />
  </div>
  <Popularity/>
  <suggest/>
</template>

<script>
import topBar from '@/components/TopBar.vue'
import Headerpar from '@/components/header.vue'
import NewUser from '@/components/NewUser.vue'
import Popularity from '@/components/Popularity.vue'
import suggest from '@/components/suggest.vue'
import userinforView from '@/components/userinforView.vue'
import { useStore } from 'vuex'
import { computed } from 'vue'
export default {

  data(){
    const stores=useStore();
    const userinfor = computed(() => stores.state.user.userinfo);
    return{
      stores,
      userinfor,
    }
  },
  components:{
    topBar,
    Headerpar,
    NewUser,
    Popularity,
    suggest,
    userinforView
  }
}
</script>

<style>
.newUser{
  z-index: 1;
  position: absolute;
  left: calc(50% - 500px);
  top: calc(50% - 250px);
  width: 1000px;
  height: 500px;
  background-image: url("../assets/images/newuser.jpg");
  background-size: 100% 100%;
}

.userv{
  position: absolute;
  width: 220px;
  height: 1200px;
  left: 10px;
  top: 170px;
}
</style>