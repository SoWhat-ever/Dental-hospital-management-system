
import { defineConfig } from 'umi';

export default defineConfig({
  nodeModulesTransform: {
    type: 'none',
  },
  routes: [
    {exact:true, path: '/', component: '@/pages/index' },
    {exact:true, path: '/home', component: '@/pages/home' },
    {exact:true, path: '/login', component: '@/pages/login' },
    {exact:true, path: '/signIn', component: '@/pages/signIn' },
    {exact:true, path: '/depart', component: '@/pages/depart' },
    {exact:true, path: '/patient', component: '@/pages/patient' },
    {exact: true, path: '/registration', component: '@/pages/registration'},
    {exact: true, path: '/registration/doctor', component: '@/pages/registration/selectdoctor'},
    {exact: true, path: '/registration/doctor/calender', component: '@/pages/registration/selectdate'},
    {exact:true, path: '/doctor', component: '@/pages/doctor' },
    {exact:true, path: '/doctorHome', component: '@/pages/doctorHome' },
    {exact:true, path: '/location', component: '@/pages/location' },
    {exact:true, path: '/question', component: '@/pages/question' },
    {exact:true, path: '/admin', component: '@/pages/admin' },
  ],
  fastRefresh: {},
});
