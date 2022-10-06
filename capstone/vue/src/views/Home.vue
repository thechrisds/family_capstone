<template>
  <div class="home">
    <div id="box-1" class="box-1">
      <div class="home-title-box">
        <h1 class="home-title">
          <a href="#box-2" class="link-style">Readitt.</a>
        </h1>
        <p class="sub-title">A family that reads together, stays together</p>
      </div>
    </div>
    <div class="white-space">
      <a href="#box-2" class="body-link"> How it works</a>
      <a href="#box-3" class="body-link"> Register|Login</a>
      <a href="#box-4" class="body-link"> About Us</a>
    </div>
    <div id="box-2">
      <br /><br /><br /><br /><br />
      <div class="home-title-box2">
        <h1 class="home-title">
          <a href="#box-3" class="link-style">How it works</a>
        </h1>
      </div>

      <div class="how-it-works-container">
        <div
          id="carouselExampleIndicators"
          class="carousel slide"
          data-bs-ride="true"
        >
          <div class="carousel-indicators">
            <button
              type="button"
              data-bs-target="#carouselExampleIndicators"
              data-bs-slide-to="0"
              class="active"
              aria-current="true"
              aria-label="Slide 1"
            ></button>
            <button
              type="button"
              data-bs-target="#carouselExampleIndicators"
              data-bs-slide-to="1"
              aria-label="Slide 2"
            ></button>
            <button
              type="button"
              data-bs-target="#carouselExampleIndicators"
              data-bs-slide-to="2"
              aria-label="Slide 3"
            ></button>
            <button
              type="button"
              data-bs-target="#carouselExampleIndicators"
              data-bs-slide-to="3"
              aria-label="Slide 4"
            ></button>
          </div>
          <div class="carousel-inner">
            <div class="carousel-item active">
              <div class="library-card">
                <h3 class="card-title" align="center">
                  Add books to your family library!
                </h3>
                <img src="@/assets/bookexample2.png" class="library-img" />
              </div>
            </div>

            <div class="carousel-item">
              <div class="record-activities-container">
                <div class="record-card">
                  <h3 class="card-title" align="center">
                    Record your reading!
                  </h3>
                </div>
                <div class="minutes-div">
                  <img src="@/assets/minutes.png" class="minutes-img" />
                </div>
              </div>
            </div>

            <div class="carousel-item">
              <div class="prizes-container">
                <div class="prizes-info">
                  <h3 class="card-title" align="center">Win Prizes!</h3>
                </div>
                <div class="prizesimg-div">
                  <img src="@/assets/prizebox.png" class="prizes-img" />
                </div>
              </div>
            </div>

            <div class="carousel-item">
              <div class="dash-card">
                <h3 class="card-title" align="center">
                  Keep track with your family dashboard!
                </h3>
                <img src="@/assets/dashboard.png" class="dash-img" />
              </div>
            </div>
          </div>

          <button
            class="carousel-control-prev"
            type="button"
            data-bs-target="#carouselExampleIndicators"
            data-bs-slide="prev"
          >
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button
            class="carousel-control-next"
            type="button"
            data-bs-target="#carouselExampleIndicators"
            data-bs-slide="next"
          >
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>
      </div>
    </div>
    <div class="white-space2">
      <a href="#box-1" class="body-link"> Top of the page</a>
      <a href="#box-3" class="body-link"> Register|Login</a>
      <a href="#box-4" class="body-link"> About Us</a>
    </div>

    <div id="box-3">
      <div class="box3-title-box">
        <h1 class="home-title">
          <a href="#box-4" class="link-style">Get started today!</a>
        </h1>
        <p class="sub-title2">
          <router-link
            id="register-or-login"
            class="links1"
            v-bind:to="{ name: 'login' }"
            >Register | Login</router-link
          >
        </p>
      </div>
    </div>
    <div class="white-space3">
      <a href="#box-1" class="body-link"> Top of the page</a>
      <a href="#box-2" class="body-link"> How it works</a>
      <a href="#box-4" class="body-link"> About Us</a>
    </div>

    <div id="box-4">
      <div class="box4-title-box">
        <h1 class="home-title">
          <br />
          <a href="#box-1" class="link-style" id="team-members">The Team</a>
        </h1>
        <p class="team-name" align="center">ROTR</p>
          <p class="team-name" align="center">Readers of the Roundtable</p>
        <div class="members">
          <img src="@/assets/team.jpg" class="team-pic" />
          <br>
          <h5>James Cagle | Chris Shriver | Daniel Song</h5>
        </div>
      </div>
    </div>
    <div class="white-space4">
      <a href="#box-1" class="body-link"> Top of the page</a>
      <a href="#box-2" class="body-link"> How it works</a>
      <a href="#box-3" class="body-link"> Register|Login</a>
    </div>
  </div>
</template>

<script>
export default {
  name: "home",
  components: {},
};
</script>

<style>
.home {
  height: 3500px;
  margin-top: 100px;
  min-width: 1000px;
}

.white-space {
  display: flex;
  justify-content: space-evenly;
  height: 400px;
  width: 60%;
  margin: auto;
  background-color: #f4f7f6;
}

.white-space2 {
  display: flex;
  justify-content: space-evenly;
  height: 400px;
  width: 60%;
  margin: auto;
  background-color: #f4f7f6;
}

.white-space3 {
  display: flex;
  justify-content: space-evenly;
  height: 400px;
  width: 60%;
  margin: auto;
  background-color: #f4f7f6;
}

.white-space4 {
  display: flex;
  justify-content: space-evenly;
  height: 50px;
  width: 60%;
  margin: auto;
  background-color: #f4f7f6;

}

.body-link {
  text-decoration: underline solid transparent;
  transition: text-decoration 1s ease;

  font-weight: 700;
  color: rgb(28, 95, 196);
  font-family: 'Montserrat', sans-serif;
  margin-top: 20px;
}

.body-link:hover {
  text-decoration: underline solid rgb(28, 95, 196);

}

.home-title {
  font-weight: bolder;
  color: rgb(28, 95, 196);
  font-size: 50px;
  text-shadow: 3px 3px 5px rgb(170, 160, 145);
  text-align: center;
  font-family: 'Montserrat', sans-serif;
}

.home-title-box {
  width: 500px;
  margin-right: 600px;
  padding-top: 200px;
}

.box-1 {
  background-image: url("../assets/bookcolumn2.png");
  width: 100%;
  height: 550px;
  justify-content: center;
  margin-top: -55px;
}

#box-2 {
  background-image: url("../assets/bookcolumn2-2.png");
  /* background-repeat: no-repeat; */

  padding-bottom: 3px;
  height: 550px;
}

#box-3 {
  background-image: url("../assets/bookcolumn2-3.png");
  background-color: white;
  /* background-repeat: no-repeat; */
  display: flex;
  flex-direction: column;
  align-content: flex-start;
  margin-top:400px;
}

.box3-title-box {
  width: 650px;
}

.sub-title2 {
  text-align: center;
}

#register-or-login {
  font-size: 30px;
  text-decoration: none;
  font-weight: 600;
}

#box-4 {
  background-image: url("../assets/bookcolumn2-4.png");
  background-color: #f4f7f6;
  /* background-repeat: no-repeat; */
  padding-top: 5px;
  height: 400px;
}

.box4-title-box {
  margin-left:-30%;
  margin-right: 600px;
  margin-top: -70px;
  text-align: center;
}

.team-pic {
  width: 250px;
  display: block;
  margin-left: auto;
  margin-right: auto;
}

.members {
  padding-top: 20px;
  padding-bottom: 20px;
  font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}

.team-name {
  font-weight: 800;
  font-size: 20px;
  color: rgb(67, 89, 185);
}

#team-members {
  font-size: 30px;
}

.link-style {
  text-decoration: none;
  color: #24305e;
  font-family: 'Montserrat', sans-serif;
  font-size: 80px;
}

.sub-title {
  text-align: center;
  font-size: 20px;
}

.card-title {
  font-size: 20px;
  color: rgb(33, 33, 129);
  text-shadow: 3px 3px 10px tomato;
}
.card-p {
  font-size: 14px;
}

.how-it-works-container {
  height: 350px;
  width: 500px;
  align-self: center;
  scroll-snap-type: x mandatory;
  scroll-behavior: smooth;
  margin: auto;
  margin-left: 50px;
}
.home-title-box2 {
  margin-right: 600px;
  margin-left: 20px;
  width: 550px;
}

.library-card {
  border: solid 2px lightgray;
  border-radius: 10px;
  margin-bottom: 30px;
  padding: 20px;
  height: 250px;
  width: 400px;
  background-color: white;
  align-self: center;
  margin-left: auto;
  margin-right: auto;
}

.library-img {
  width: 350px;
  height: auto;
}

.record-activities-container {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-content: center;
  border: solid 2px lightgray;
  border-radius: 10px;
  margin-bottom: 30px;
  margin-left: auto;
  margin-right: auto;
  padding: 20px;
  height: 250px;
  width: 350px;
  background-color: white;
}

.record-card {
  width: 300px;
  margin-bottom: 20px;
}

.minutes-img {
  width: 150px;
  height: auto;
  align-content: center;
  margin-bottom: 30px;
  margin-left: 75px;
}

.minutes-img:hover {
  animation: shake 0.5s;
  animation-iteration-count: infinite;
}

@keyframes shake {
  0% {
    transform: translate(1px, 1px) rotate(0deg);
  }
  10% {
    transform: translate(-1px, -2px) rotate(-1deg);
  }
  20% {
    transform: translate(-3px, 0px) rotate(1deg);
  }
  30% {
    transform: translate(3px, 2px) rotate(0deg);
  }
  40% {
    transform: translate(1px, -1px) rotate(1deg);
  }
  50% {
    transform: translate(-1px, 2px) rotate(-1deg);
  }
  60% {
    transform: translate(-3px, 1px) rotate(0deg);
  }
  70% {
    transform: translate(3px, 1px) rotate(-1deg);
  }
  80% {
    transform: translate(-1px, -1px) rotate(1deg);
  }
  90% {
    transform: translate(1px, 2px) rotate(0deg);
  }
  100% {
    transform: translate(1px, -2px) rotate(-1deg);
  }
}

.prizes-container {
  display: flex;
  border: solid 2px lightgray;
  border-radius: 10px;
  margin-bottom: 30px;
  margin-left: auto;
  margin-right: auto;
  padding: 20px;
  height: 250px;
  width: 350px;
  background-color: white;
}

.prizes-info {
  width: 100px;
  height: auto;
  margin-top:50px;
}

.prizes-img {
  width: 200px;
}

.dash-card {
  display: flex;
  flex-direction: column;
  align-content: center;
  border: solid 2px lightgray;
  border-radius: 10px;
  margin-bottom: 30px;
  margin-left: auto;
  margin-right: auto;
  padding: 15px;
  height: 250px;
  width: 350px;
  background-color: white;
}

.dash-img {
  width: 250px;
  margin:auto;
}


.box3-content {
  display: flex;
  justify-content: space-between;
  align-content: center;
}


</style>
