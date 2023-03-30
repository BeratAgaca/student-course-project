import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router' 
import CourseDetails from '../views/CourseDetails.vue'
import StudentDetails from '../views/StudentDetails.vue'
import HomeView from '../views/HomeView.vue'
Vue.use(VueRouter)

const routes: Array<RouteConfig> = [
    {
      path: '/studentPage',
      name: 'students',
      component: StudentDetails
    },
    {
      path: '/coursePage',
      name: 'courses',
      component: CourseDetails
    },
    {
      path: '/',
      name: 'home',
      component: HomeView
    }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
