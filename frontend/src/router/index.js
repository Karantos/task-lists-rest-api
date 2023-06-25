// Composables
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    // get all lists
    path: '/',
    alias: '/home',
    name: 'home',
    component: () => import('@/components/Lists'),
  },
  {
    path: '/save-list',
    name: 'save-list',
    component: () => import('@/components/AddList'),
  },
  {
    // get tasks by list id
    path: '/tasks/:id',
    name: 'tasks',
    component: () => import('@/components/Tasks'),
  },
]


const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
