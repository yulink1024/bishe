import { createStore } from 'vuex'

//用户信息
const userModule={
    namespaced:true,
    state:()=>{
    return{
        userinfo:{}
    }
    },
    mutations:{
    setUserinfo(state,usermess){
        state.userinfo=usermess
    },
    setIsonline(state){
        state.userinfo.isonline=!state.userinfo.isonline
    }
    },
    actions:{
    
    },
    getters:{
    
    }
}

//热榜
const TopGoodsModule={
  namespaced:true,
  state:()=>{
    return{
        topgoods:[]
    }
    },
    mutations:{
    setTop(state,usermess){
        state.topgoods=usermess
    },
    },
    actions:{
    
    },
    getters:{
    
    }
}

//用户标签信息
const UserInterestsModule={
    namespaced:true,
    state:()=>{
        return{
            userInterests:{}
        }
    },
    mutations:{
        setuserInterests(state,usin){
            state.userInterests=usin
        }
    },
    getters:{
        getuserInterests(state){
            return state.userInterests
        }
    }
}

//推荐
const SuggestMoudle={
    namespaced:true,
    state:()=>{
        return {
            SuggestList:[]
        }
    },
    mutations:{
        setSuggestList(state,sugges){
            state.SuggestList=sugges
        }
    }
}
export default createStore({
  modules:{
    user: userModule,
    hotgood: TopGoodsModule,
    UserInterest:UserInterestsModule,
  }
})
