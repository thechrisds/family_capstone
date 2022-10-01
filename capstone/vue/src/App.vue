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

          <router-link v-else id="links" class="links6" v-bind:to="{ name: 'login' }"
            >Login</router-link
          >


        </nav>
        <router-link class="img-link" v-bind:to="{ name: 'home' }">
        <h4 class="title">READITT.</h4>
        </router-link>
        <router-link v-bind:to="{ name: 'home' }">
          <img class="book-cover" src="@/assets/bookcover1.png" />
          </router-link>
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
  font-family: 'Raleway', sans-serif;
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
  color: rgb(104, 32, 32);
  margin-right: 40px;
  margin-left: 40px;
}

.title {
  font-weight: 900;
  color: rgb(104, 32, 32);
  font-size: 25px;
  text-shadow: 3px 3px rgb(175, 154, 125);
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
  color: rgb(104, 32, 32);
}

.links1:hover {
  color: #c71a1a;
  text-shadow: 3px 3px 3px gray
}

.links2 {
  color: rgb(104, 32, 32);
}
.links2:hover {
  color: #358a3c;
  text-shadow: 3px 3px 3px gray;
}

.links3 {
  color: rgb(104, 32, 32);
}
.links3:hover {
  color: #3537cc;
  text-shadow: 3px 3px 3px gray
}

.links4 {
  color: rgb(104, 32, 32);
}
.links4:hover {
  color: #e77e1b;
  text-shadow: 3px 3px 3px gray
}

.links5 {
  color: rgb(104, 32, 32);
}
.links5:hover {
  color: rgb(155, 13, 155);
  text-shadow: 3px 3px 3px gray
}

.links6 {
  color: rgb(95, 165, 189);
}
.links6:hover {
  color: rgb(155, 13, 155);
  text-shadow: 3px 3px 3px gray
}

.img-link {
  text-decoration: none;
}

</style>
