<template>
  <div id="app">
    <div class="header-bar">
      <nav class="top-nav">
        <router-link id="links" class="links1" v-bind:to="{ name: 'home' }"
          >Home</router-link
        >
        <router-link
          id="links"
          class="links2"
          v-bind:to="{ name: 'account' }"
          v-if="$store.state.token != ''"
          >View Account</router-link
        >
        <router-link id="links" class="links3" v-bind:to="{ name: 'books' }"
          >Books</router-link
        >
        <router-link id="links" class="links4" v-bind:to="{ name: 'Activity' }"
          >Activity</router-link
        >
        <router-link
          id="links"
          class="links5"
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link
        >
      </nav>
      <h4 class="title">Family Reader App</h4>
    </div>
    <br />
    <div class="book-banner">
      <img src="@/assets/bookbanner.png" class="banner" />
    </div>
    <div id="container">
      <router-view />
    </div>
  </div>
</template>

<style>
#app {
  max-width: 950px;
  margin: auto;
}

.banner {
  padding-top: 20px;
  width: 100%;
  height: 50px;
  position: fixed;
  
  background-color: white;
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
  justify-content: center;
  align-items: center;
  overflow: hidden;
  position: fixed;
  padding-top: 0px;
  padding-bottom: 5px;
  padding-left: 5px;
  padding-right: 5px;
  width: 100%;
  height: 25px;
  border-bottom: 2px solid lightskyblue;
  background-color: white;
}

.top-nav {
  display: flex;
  flex-basis: 80%;
  justify-content: space-evenly;
  
  align-items: center;
  color: rgb(42, 91, 107);
  text-align: center;
  font-size: 15px;
  padding-bottom: 25px;
  font-weight: 600;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
}

#links {
  display: flex;
  justify-content: center;
  padding-top: 15px;
  text-decoration: none;
}

.links1:hover {
  color: #c71a1a;
}

.links3:hover {
  color: #1b1fe7;
}
#container {
  display: flex;
  flex-direction: column;
  padding-top: 10px;
  margin-top: 100px;
  flex-wrap:wrap;
}

.title {
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  display: flex;
  justify-content: center;
  align-items: stretch;
  padding-bottom: 10px;
}
</style>
