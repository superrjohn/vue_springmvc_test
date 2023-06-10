<template>
  <div >
    <router-link to="/home">首頁</router-link>
    <router-link to="/about"> About</router-link>
    <router-link to="/app">App</router-link>
    <router-link to="/movie/1"> movie</router-link>
    <router-link to="/movie/2"> movie</router-link>
    <router-view></router-view>
  </div>
</template>

<script>
import router from './router';

export default {
    components: { router }
}
</script>

<style>

</style>