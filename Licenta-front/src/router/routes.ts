import { RouteRecordRaw } from 'vue-router';

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      {
        path: '',
        meta: {
          isPublic: true,
        },
        component: () => import('pages/IndexPage.vue'),
      },
      {
        path: '/login',
        meta: {
          isPublic: true,
        },
        component: () => import('pages/LoginPage.vue'),
      },
      {
        path: '/register',
        meta: {
          isPublic: true,
        },
        component: () => import('pages/RegisterPage.vue'),
      },
      { path: '/cart', component: () => import('pages/CartPage.vue') },
      {
        path: '/product',
        meta: {
          isPublic: true,
        },
        component: () => import('pages/ProductPage.vue'),
      },
      {
        path: '/products',
        meta: {
          isPublic: true,
        },
        component: () => import('pages/ProductsPage.vue'),
      },
      {
        path: '/my-account',
        component: () => import('pages/MyAccountPage.vue'),
      },
      {
        path: '/admin',
        component: () => import('pages/AdministratorPage.vue'),
      },
    ],
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue'),
  },
];

export default routes;
