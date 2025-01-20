import React from "react";
interface Props {
  icon: React.ReactNode;
  onClick: () => void;
}
const IconButton: React.FC<Props> = ({ icon, onClick }) => {
  return (
    <button
      onClick={(e) => {
        e.preventDefault();
        onClick();
      }}
    >
      {icon}
    </button>
  );
};

export default IconButton;
