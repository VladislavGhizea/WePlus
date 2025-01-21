import React from "react";

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

const Container: React.FC<Props> = ({
  values: { name, surname, age, job, gender, city, isStarred, hobby, contact },
}) => {
  name="Mr";
  surname="Griddy"
  age=20
  job="metodoindiano"
  gender="Non Binario"
  city="Savona"
  isStarred=true
  hobby=["Mangio sassi mentre guardo Minecraft"]
  contact= {email: "asNan@gmail.com", phone: 94813874592}
  
  return <div className="bg-buttonGrey h-[13.5rem] w-[52rem]">
    <div className="grid gridbg-white h-[10rem] w-[34rem]">
      {/* <DataSection></DataSection> */}
    </div>
  </div>
};

export default Container;
