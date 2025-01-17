import fetchWrapper from './fetchWrapper';

// Recupera tutte le persone fisiche
export const getAllPersoneFisiche = async () => {
  return await fetchWrapper('/PersonaFisica');
};

// Recupera una persona fisica per ID
export const getPersonaFisicaById = async (id) => {
  return await fetchWrapper(`/PersonaFisica/${id}`);
};

// Crea una nuova persona fisica
export const createPersonaFisica = async (persona) => {
  return await fetchWrapper('/PersonaFisica', {
    method: 'POST',
    body: JSON.stringify(persona),
  });
};

// Aggiorna una persona fisica esistente
export const updatePersonaFisica = async (id, persona) => {
  return await fetchWrapper(`/PersonaFisica/${id}`, {
    method: 'PUT',
    body: JSON.stringify(persona),
  });
};

// Elimina una persona fisica
export const deletePersonaFisica = async (id) => {
  return await fetchWrapper(`/PersonaFisica/${id}`, {
    method: 'DELETE',
  });
};
