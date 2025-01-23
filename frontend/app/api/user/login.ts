import { SERVER } from '../../variables'

interface User {
    soggetto_id: number;
    username: string;
    email: string;
    password: string;
    tipo: "FISICA" | "GIURIDICA" | "INDIVIDUALE" | "ADMIN";
    cancellato: boolean;
}

const login = async (username: string, password: string): Promise<boolean> => {
    if(!username || !password){
        console.error('Username e password sono richiesti');
        return false;
    }
    
    try{
        const response = await fetch(`${SERVER}/utentiGenerali`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
            
        })
        const data: User[] = await response.json()
        for (const user of data) {
            if (user.username === username && user.password === password) {
                localStorage.setItem('username', username)
                localStorage.setItem('password', password)
                localStorage.setItem('id', user.soggetto_id.toString())
                localStorage.setItem('role', user.tipo)
                return true; //accesso consentito
            }
        }

    }catch(error){
        console.error(`Abbiamo avuto un problema con il login: ${error}`)
    }
    
    return false; //accesso negato
}