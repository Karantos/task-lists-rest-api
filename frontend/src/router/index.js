// Composables
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    // get all lists
    path: '/',
    alias: '/home',
    name: 'home',
    component: () => import('@/views/Lists'),
  },
  {
    path: '/add-list',
    name: 'add-list',
    component: () => import('@/views/AddList'),
  },
  {
    path: '/update-list/:id',
    name: 'update-list',
    component: () => import('@/views/UpdateList'),
  },
  {
    // get tasks by list id
    path: '/tasks/:id',
    name: 'tasks',
    component: () => import('@/views/Tasks'),
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
