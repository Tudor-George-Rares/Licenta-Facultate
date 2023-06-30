<template>
  <q-page class="flex flex-start justify-center q-pa-xl">
    <q-card style="max-width: 800px; min-width: 400px; height: fit-content">
      <q-card-section>
        <q-toolbar>
          <q-toolbar-title>Inregistrare</q-toolbar-title>
        </q-toolbar>
      </q-card-section>
      <q-card-section>
        <q-form @submit="onSubmit">
          <q-input
            v-model="nume"
            label="Nume"
            lazy-rules
            :rules="[(val) => !!val || 'Numele este necesar']"
          />
          <q-input
            v-model="prenume"
            label="Prenume"
            lazy-rules
            :rules="[(val) => !!val || 'Prenumele este necesar']"
          />
          <q-input
            v-model="email"
            label="Email"
            lazy-rules
            :rules="[(val) => !!val || 'Email-ul este necesar']"
          />
          <q-input
            v-model="username"
            label="Utilizator"
            lazy-rules
            :rules="[(val) => !!val || 'Utilizator-ul este necesar']"
          />
          <q-input
            v-model="password"
            label="Parola"
            lazy-rules
            :rules="[
              (val) => !!val || 'Parola este necesara',
              (val) =>
                (val && val.length >= 8) ||
                'Parola trebuie sa contina cel putin 8 caractere',
            ]"
          />
          <q-input
            v-model="adresa"
            label="Adresa"
            lazy-rules
            :rules="[(val) => !!val || 'Adresa este necesara']"
          />
          <q-input
            v-model="telefon"
            label="Telefon"
            lazy-rules
            :rules="[(val) => !!val || 'Telefonul este necesar']"
          />

          <q-btn
            label="Du-ma la autentificare"
            color="primary"
            outline
            class="q-mt-md"
            @click="redirectAuth"
          />
          <q-btn
            type="submit"
            label="Inregistrare"
            color="primary"
            class="q-mt-md q-ml-xl"
          />
        </q-form>
      </q-card-section>
    </q-card>
  </q-page>
</template>

<script>
import { defineComponent, ref } from 'vue';
import { api } from 'boot/axios';
import { useRouter } from 'vue-router';
export default defineComponent({
  setup() {
    const email = ref('');
    const password = ref('');
    const nume = ref('');
    const prenume = ref('');
    const telefon = ref('');
    const adresa = ref('');
    const username = ref('');
    const router = useRouter();
    const onSubmit = async () => {
      try {
        const response = await api.post('/auth/signup', {
          username: username.value,
          password: password.value,
          email: email.value,
          nume: nume.value,
          prenume: prenume.value,
          telefon: telefon.value,
          adresaCompleta: adresa.value,
          role: ['user'],
        });
        if (response.status === 200) {
          router.push('/');
        }
      } catch (error) {
        console.error(error);
      }
    };

    const redirectAuth = () => {
      router.push('/login');
    };

    return {
      email,
      password,
      onSubmit,
      nume,
      prenume,
      telefon,
      adresa,
      username,
      redirectAuth,
    };
  },
});
</script>

<style></style>
