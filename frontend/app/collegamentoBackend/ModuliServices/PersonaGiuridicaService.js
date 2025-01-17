import fetchWrapper from './fetchWrapper';

// Recupera tutte le persone giuridiche
export const getAllPersoneGiuridiche = async () => {
  return await fetchWrapper('/PersoneGiuridiche');
};

// Recupera una persona giuridica per ID
export const getPersonaGiuridicaById = async (id) => {
  return await fetchWrapper(`/PersoneGiuridiche/${id}`);
};

// Crea una nuova persona giuridica
export const createPersonaGiuridica = async (persona) => {
  return await fetchWrapper('/PersoneGiuridiche', {
    method: 'POST',
    body: JSON.stringify(persona),
  });
};

// Aggiorna una persona giuridica esistente
export const updatePersonaGiuridica = async (id, persona) => {
  return await fetchWrapper(`/PersoneGiuridiche/${id}`, {
    method: 'PUT',
    body: JSON.stringify(persona),
  });
};

// Elimina una persona giuridica
export const deletePersonaGiuridica = async (id) => {
  return await fetchWrapper(`/PersoneGiuridiche/${id}`, {
    method: 'DELETE',
  });
};
