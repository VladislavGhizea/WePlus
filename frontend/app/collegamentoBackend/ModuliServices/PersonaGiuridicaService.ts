import fetchWrapper from '../fetchWrapper';

interface PersonaGiuridica {
  // Definisci qui le proprietà dell'interfaccia PersonaGiuridica
  id?: number;
  pIva: string;
  tipoSocieta: string;
  ragioneSociale: string;
  sede: string;
  principale: boolean;
}

// Recupera tutte le persone giuridiche
export const getAllPersoneGiuridiche = async (): Promise<PersonaGiuridica[]> => {
  return await fetchWrapper('/PersoneGiuridiche') as PersonaGiuridica[];
};

// Recupera una persona giuridica per ID
export const getPersonaGiuridicaById = async (id: number): Promise<PersonaGiuridica> => {
  return await fetchWrapper(`/PersoneGiuridiche/${id}`) as PersonaGiuridica;
};

// Crea una nuova persona giuridica
export const createPersonaGiuridica = async (persona: PersonaGiuridica): Promise<PersonaGiuridica> => {
  return await fetchWrapper('/PersoneGiuridiche', {
    method: 'POST',
    body: JSON.stringify(persona),
  }) as PersonaGiuridica;
};

// Aggiorna una persona giuridica esistente
export const updatePersonaGiuridica = async (id: number, persona: PersonaGiuridica): Promise<PersonaGiuridica> => {
  return await fetchWrapper(`/PersoneGiuridiche/${id}`, {
    method: 'PUT',
    body: JSON.stringify(persona),
  }) as PersonaGiuridica;
};

// Elimina una persona giuridica
export const deletePersonaGiuridica = async (id: number): Promise<void> => {
  await fetchWrapper(`/PersoneGiuridiche/${id}`, {
    method: 'DELETE',
  });
};