import Vue from 'vue'
import Router from 'vue-router'

import Home from '../components/Home'
import Appindex from '../components/home/Appindex'
import Login from '../components/Login'
import LibraryIndex from '../components/library/LibraryIndex'
import JotterIndex from '../components/jotter/JotterIndex'
import About from '../components/About'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/home',
      name: 'Home',
      component: Home,
      redirect: '/index',
      children: [
        {
          path: '/index',
          name: 'AppIndex',
          component: Appindex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/about',
          name: 'About',
          component: About,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/library',
          name: 'Library',
          component: LibraryIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/jotter',
          name: 'jotter',
          component: JotterIndex,
          meta: {
            requireAuth: true
          }
        }
      ]
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
})
