<template>
  <div id="app">
    <div class="header">
      <div class="header-bar">
        <nav class="top-nav">
          <router-link id="links" class="links1" v-bind:to="{ name: 'home' }"
            >Home</router-link
          >
          <router-link id="links" class="links2" v-bind:to="{ name: 'account' }"
            >Dashboard</router-link
          >
          <router-link id="links" class="links3" v-bind:to="{ name: 'books' }"
            >Books</router-link
          >
          <router-link
            id="links"
            class="links4"
            v-bind:to="{ name: 'activity' }"
            >Reading Activity</router-link
          >
          <router-link
            id="links"
            class="links5"
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
            >Logout</router-link
          >
        </nav>
        <h4 class="title">READITT.</h4>
        <img class="book-cover" src="@/assets/bookcover1.png" />
      </div>
      <div class="book-banner">
        <img src="@/assets/bookbanner5.png" class="banner" />
      </div>
    </div>
    <div id="container">
      <router-view />
    </div>
  </div>
</template>

<style>
body {
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  font-weight: 700;
  font-size: 12px;
}
#app {
  display: flex;
  flex-direction: column;
  min-width: 450px;
  margin: auto;
  max-width: 1500;
}

.book-banner {
  display: flex;
  justify-content: center;
  padding-bottom: 15px;
  margin-top: 15px;
  max-width: 100%;
  height: auto;
}

.banner {
  height: 75px;
  width: 1500px;
  opacity: 1;
  box-shadow: 10px 10px 5px rgb(127, 131, 133);
}
#family-account {
  min-height: 0;
  padding-top: 10px;
  padding-bottom: 10px;
  margin-top: 100px;
}

#all-books {
  min-height: 0;
  padding-top: 10px;
}

.header {
  background-color: rgb(254, 254, 255);
  position: fixed;
  width: 100%;
  margin: -10px;
  border-top: 10px solid black;
  border-radius: 10px;
}
.header-bar {
  display: flex;
  justify-content: center;
  align-items: center;
  padding-top: 0px;
  padding-left: 5px;
  padding-right: 5px;
  height: 30px;
  margin-right: 40px;
}

.top-nav {
  display: flex;
  justify-content: space-between;
  width: 1000px;
  padding-bottom: 5px;
  color: lightblue;
  margin-right: 40px;
}
.title {
  font-weight: 900;
  color: rgb(128, 212, 240);
  font-size: 25px;
  text-shadow: 3px 3px rgb(192, 230, 243);
  margin-left: 40px;
}

.book-cover {
  width: 25px;
  height: 35px;
  padding-left: 5px;
  box-shadow: 5px 5px 5px rgb(127, 131, 133);
}

#links {
  display: flex;
  justify-content: center;
  padding-top: 15px;
  text-decoration: none;
  font-size: 14px;
  padding-bottom: 10px;
}
.links1 {
  color: rgb(95, 165, 189);
}

.links1:hover {
  color: #c71a1a;
}

.links2 {
  color: rgb(95, 165, 189);
}
.links2:hover {
  color: #07be16;
}

.links3 {
  color: rgb(95, 165, 189);
}
.links3:hover {
  color: #1b1fe7;
}

.links4 {
  color: rgb(95, 165, 189);
}
.links4:hover {
  color: #e77e1b;
}

.links5 {
  color: rgb(95, 165, 189);
}
.links5:hover {
  color: magenta;
}

#container {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
}
</style>
