import fetchWrapper from '../fetchWrapper';

interface PersonaFisica {
  // Definisci qui le proprietà dell'interfaccia PersonaFisica
  id?: number;
  nome: string;
  cognome: string;
  codiceFiscale: string;
  sesso: string;
  genere: string;
  comuneDiNascita: string;
  dataDiNascita: string;
  indirizzoDiDomicilio: string;
  indirizzoDiResidenza: string;
}

// Recupera tutte le persone fisiche
export const getAllPersoneFisiche = async (): Promise<PersonaFisica[]> => {
  return await fetchWrapper('/PersonaFisica') as PersonaFisica[];
};

// Recupera una persona fisica per ID
export const getPersonaFisicaById = async (id: number): Promise<PersonaFisica> => {
  return await fetchWrapper(`/PersonaFisica/${id}`) as PersonaFisica;
};

// Crea una nuova persona fisica
export const createPersonaFisica = async (persona: PersonaFisica): Promise<PersonaFisica> => {
  return await fetchWrapper('/PersonaFisica', {
    method: 'POST',
    body: JSON.stringify(persona),
  }) as PersonaFisica;
};

// Aggiorna una persona fisica esistente
export const updatePersonaFisica = async (id: number, persona: PersonaFisica): Promise<PersonaFisica> => {
  return await fetchWrapper(`/PersonaFisica/${id}`, {
    method: 'PUT',
    body: JSON.stringify(persona),
  }) as PersonaFisica;
};

// Elimina una persona fisica
export const deletePersonaFisica = async (id: number): Promise<void> => {
  await fetchWrapper(`/PersonaFisica/${id}`, {
    method: 'DELETE',
  });
};