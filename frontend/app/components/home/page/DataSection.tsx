import React from "react";
import { HiChevronDown } from "react-icons/hi2";


interface Props {
    values: {
        name: string;
        surname: string;
        age: number;
        job: string;
        gender: string;
        city: string;
        isStarred: boolean;
        hobby: string[];
        contact: { email: string, phone: number };
    };

}

const DataSection: React.FC<Props> ({
    values: { name, surname, age, job, gender, city, isStarred, hobby, contact },
}) => {
    name = "Mr";
    surname = "Griddy"
    age = 20
    job = "metodoindiano"
    gender = "Non Binario"
    city = "Savona"
    isStarred = true
    hobby = ["Mangio sassi mentre guardo Minecraft"]
    contact = { email: "asNan@gmail.com", phone: 94813874592 }

    return (
        <div className="grid grid-cols-3 grid-rows-2">
           <div>
               {job}
           </div>
           <div>
               {name}
           </div>
           <div>
               {surname}
           </div>
           <div>
               {age}
           </div>
           <div>
               <HiChevronDown className="mr-2 h-6 w-6" />
           </div>
           <div>
               {gender}
           </div>
           <div>
               {city}
           </div>
           
           



        </div>
    )
};

export default DataSection;