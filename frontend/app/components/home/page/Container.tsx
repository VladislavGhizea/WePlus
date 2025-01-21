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
    contact: { email: string; phone: number };
  };
}

const Container: React.FC<Props> = ({
  values: { name, surname, age, job, gender, city, isStarred, hobby, contact },
}) => {
  return <div className="bg-"></div>;
};

export default Container;
