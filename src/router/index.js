import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    name: 'operadoras',
    component: () => import('@/views/OperadorasView.vue') 
  }
]

const router = createRouter({
  history:  createWebHistory('/'),
  routes
})

export default router