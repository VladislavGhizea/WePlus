import { ActionButton } from "@/app/components/home/buttons";

const Footer: React.FC<{ handleNext: () => void; handlePrev: () => void }> = ({
  handleNext,
  handlePrev,
}) => (
  <>
    <div className="absolute items-center right-[4.5rem] mt-[2.5rem]">
      <ActionButton
        text="Avanti"
        bgColor="bg-buttonBlue"
        onClick={handleNext}
      />
    </div>
    <div className="absolute items-center left-[4.5rem] mt-[2.5rem]">
      <ActionButton
        text="Indietro"
        bgColor="bg-buttonBlue"
        onClick={handlePrev}
      />
    </div>
  </>
);
export default Footer;
