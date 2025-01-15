import React from "react";

interface Props {
  children: React.ReactNode;
  image: React.ReactNode;
  button: React.ReactNode;
}

const Section: React.FC<Props> = ({ children, image, button }) => {
  return (
    <div className="grid grid-rows-3 justify-center justify-items-center items-center pt-12 h-full">
      <div className=" w-28 h-28">{image}</div>
      <div className="text-3xl px-[4.5rem] text-center mt-[2rem]">
        {children}
      </div>
      <div className="">{button}</div>
    </div>
  );
};

export default Section;
