<template>
  <div id="app">
    <div class="header-bar">
    <nav class="top-nav">
      <router-link id="links" class="links1" v-bind:to="{ name: 'home' }"
        >Home</router-link
      >&nbsp;|&nbsp;
      <router-link
        id="links"
        class="links2"
        v-bind:to="{ name: 'account' }"
        v-if="$store.state.token != ''"
        >View Account</router-link
      >&nbsp;|&nbsp;
      <router-link id="links" class="links3" v-bind:to="{ name: 'books' }"
        >Books</router-link
      >&nbsp;|&nbsp;
      <router-link id="links" class="links4" v-bind:to="{ name: 'addActivity' }"
        >Add Activity</router-link
      >&nbsp;|&nbsp;
      <router-link
        id="links"
        class="links5"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link>
    </nav>
    <h5>ICON GOES HERE</h5>
    </div>
    <div id="container">
      <router-view />
    </div>
  </div>
</template>

<style>
#app {
}
.loading {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: auto;
  height: auto;
}

.header-bar {
  display: flex;
  justify-content:space-evenly;
  align-items: center;
  border-bottom: solid lightblue 3px;
  overflow: hidden;
  position: fixed;
  padding-top: 0px;
  padding-bottom: 5px;
  padding-left: 5px;
  padding-right: 5px;
  width: 100%;
  background-color: lightcoral;
}

.top-nav {
  display: flex;
  flex-basis: 80%;
  justify-content:space-evenly;
  align-items: center;
}

#links {
  display:flex;
  color: rgb(42, 91, 107);
  text-align: center;
  justify-content: center;
  padding-top: 15px;
  text-decoration: none;
  font-size: 18px;
}

.links1:hover {
  color: #c71a1a;
}

.links3:hover {
  color: #1b1fe7;
}
#container {
  padding-top: 100px;
}
</style>
