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
          <router-link
            id="links"
            class="links4"
            v-bind:to="{ name: 'Activity' }"
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
        <h4 class="title">READITT.</h4>
      </div>
      <br />
      <div class="book-banner">
        <img src="@/assets/bookbanner3.png" class="banner" />
      </div>
      <div id="container">
        <router-view />
      </div>
    </div>
</template>

<style>
body{
  background-color: rgb(246, 247, 248) ;
}
#app {
  max-width: 1250px;
  margin: auto;
  align-content: center;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
}

.book-banner{
  margin-left:20px;

}

.banner {
  height: 50px;
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
  background-color: white;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
}

.top-nav {
  display:flex;
  float:left;
  justify-content: space-evenly;
  align-items: center;
  flex-basis: auto;
  width: 750px;
  padding-bottom: 5px;
  font-weight: 700;
  color:lightblue;
}


#links {
  display: flex;
  justify-content: center;
  padding-top: 15px;
  text-decoration: none;
  color:rgb(114, 204, 235);
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
  flex-wrap: wrap;
  
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
