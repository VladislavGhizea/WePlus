import classNames from "classnames";
import React from "react";
import { HiChevronDown } from "react-icons/hi2";
interface Props {
  icon: React.ReactNode;
  text: string;
  onClick: () => void;
  classNameContainer?: string;
}
const Category: React.FC<Props> = ({ icon, text, classNameContainer }) => {
  classNameContainer = classNameContainer || "justify-between";
  return (
    <button className={classNames(classNameContainer,"flex items-center w-full p-2")}>
      <div className="flex flex-row justify-center items-center">
        {icon}
        <p className="ml-2 text-md justify-center items-center">{text}</p>
      </div>
      <HiChevronDown className="mr-2 h-6 w-6" />
    </button>
  );
};

export default Category;
