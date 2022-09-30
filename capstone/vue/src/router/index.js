import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import ViewLibrary from '../views/ViewLibrary.vue'
import Activity from '../views/Activity.vue'
import AddActivity from '../views/AddActivity.vue'
import AddBook from '../views/AddBook.vue'
import FamilyAccount from '../views/FamilyAccount.vue'
import InvalidPath from '../views/InvalidPath.vue'
import PersonalLibrary from '../views/PersonalLibrary.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/books/all",
      name: "books",
      component: ViewLibrary,
      meta: {
        requiresAuth: false
        }
      },
    {
      path: "/books/add",
      name: "addBook",
      component: AddBook,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/books",
      name: "showBooks",
      component: PersonalLibrary,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/account",
      name: "account",
      component: FamilyAccount,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/activity/family",
      name: "activity",
      component: Activity,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/activity/user",
      name: "addActivity",
      component: AddActivity,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/:catchAll(.*)",
      name: "dne",
      component: InvalidPath

    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
