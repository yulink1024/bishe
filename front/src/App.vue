<template>
<!-- 一级路由出口 -->
<router-view />

</template>

<style lang="less" scoped>
@import url('./assets/styles/mixins.less');

.headdi{
  display: flex;
  justify-content: center;
}
.headsp{
  display: inline-block;
  width: 100px;
  height: 50px;
  margin: 5px;
  background-color: #e9de0e;
  text-align: center;
}
</style>
