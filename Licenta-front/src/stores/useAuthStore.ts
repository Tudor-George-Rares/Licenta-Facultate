import { defineStore } from 'pinia';
import { api } from 'boot/axios';

export const useAuthStore = defineStore({
  id: 'auth',
  state: () => ({
    username: null,
    email: null,
    adresaCompleta: null,
    id: null,
    nume: null,
    prenume: null,
    roles: null,
    telefon: null,
  }),
  getters: {
    isAuthenticated: (state) => !!state.username,
  },
  actions: {
    async login(username: string, password: string) {
      try {
        console.log('login', username, password);
        const response = await api.post('/auth/signin', {
          username,
          password,
        });
        this.username = response.data.username;
        this.email = response.data.email;
        this.adresaCompleta = response.data.adresaCompleta;
        this.id = response.data.id;
        this.nume = response.data.nume;
        this.prenume = response.data.prenume;
        this.roles = response.data.roles;
        this.telefon = response.data.telefon;
        return response;
      } catch (error) {
        console.error(error);
      }
    },
    async logout() {
      try {
        const response = await api.post('/auth/logout', {});
        this.username = null;
        this.email = null;
        this.adresaCompleta = null;
        this.id = null;
        this.nume = null;
        this.prenume = null;
        this.roles = null;
        this.telefon = null;
      } catch (error) {
        console.error(error);
      }
    },
  },
  persist: true,
});
