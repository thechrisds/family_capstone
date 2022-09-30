<template>
    <div id="app">
      <div class="header">
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
          <router-link id="links" class="links4" v-bind:to="{ name: 'activity' }"
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

}
#app {
  min-width: 450px;
  margin: auto;
  align-content: center;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
    max-width: 1800px;
}

.book-banner{
  display:flex;
  margin-left:20px;
  justify-content: center;
  padding-bottom: 15px;
}

.banner {
  height: 75px;
  width: 1300px;
}
#family-account{
  min-height: 0;
  padding-top: 10px;
}

#all-books {
  min-height: 0;
  padding-top: 10px;
}

.header {
    background-color: rgb(254, 254, 255);
    border-right:5px solid lightgrey;

}
.header-bar {
  display: flex;
  justify-content: center;
  align-items: center;
  overflow: hidden;
  padding-top: 0px;
  padding-left: 5px;
  padding-right: 5px;
  height: 30px;
  margin-right: 40px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
}

.top-nav {
  display:flex;
  float:left;
  justify-content: space-evenly;
  align-items: center;
  flex-basis: auto;
  width: 1000px;
  padding-bottom: 5px;
  font-weight: 700;
  color:lightblue;
}

#links {
  display: flex;
  justify-content: center;
  padding-top: 15px;
  text-decoration: none;
  
 
}
.links1{
  color: rgb(95, 165, 189);
}

.links1:hover {
  color: #c71a1a;
}

.links2{
  color: rgb(95, 165, 189);
}
.links2:hover {
  color: #07be16;
}

.links3{
  color: rgb(95, 165, 189);
}
.links3:hover {
  color: #1b1fe7;
}

.links4{
  color: rgb(95, 165, 189);
}
.links4:hover {
  color: #e77e1b;
}

.links5{
  color: rgb(95, 165, 189);
}
.links5:hover {
  color:magenta;
}

#container {
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  justify-content: space-evenly;
  
}

.title {
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  padding-top: 10px;
  font-weight: 900;
  color: rgb(128, 212, 240);
  font-size: 25px;
  text-shadow: 5px 5px lightgray;
  margin-left:40px;
}
</style>
