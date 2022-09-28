<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'account' }" v-if="$store.state.token != ''">View Account</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'books' }">Books</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'addActivity' }">Add Activity</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
    </div>
    <router-view />
  </div>
</template>

<style>
#app{
  
}
</style>
