import { SelectedPage } from "../../shared/types";
import Logo from "../../../../assets/logo.png";
import bug from "../../../../assets/bug.png";
import video from "../../../../assets/video.mp4";
import { motion } from "framer-motion";
import { Link, useNavigate } from "react-router-dom";
import giphy from "../../../../assets/giphy.gif";

type Props = {
  setSelectedPage: (value: SelectedPage) => void;
};

const Home = ({ setSelectedPage }: Props) => {


  return (
    <section id="home" className="gap-16 bg-black py-20 md:h-full md:pb-0">
      {/* IMAGE AND MAIN HEADER */}
      <motion.div
        className="mx-auto w-5/6 items-center justify-center md:flex md:h-5/6"
        onViewportEnter={() => setSelectedPage(SelectedPage.Home)}
      >
        {/* MAIN HEADER */}
        <div className="z-10 mt-22 md:basis-3/5">
          {/* HEADINGS */}
          <motion.div
            className="md:-mt-20"
            initial="hidden"
            whileInView="visible"
            viewport={{ once: true, amount: 0.5 }}
            transition={{ duration: 0.5 }}
            variants={{
              hidden: { opacity: 0, x: -50 },
              visible: { opacity: 1, x: 0 },
            }}
          >
            <div className="relative">
              <div className="before:absolute before:-top-20 before:-left-20 before:z-[-1] md:before:content-evolvetext">
                <img alt="logo" src={Logo} />
              </div>
            </div><br/>
            <h1 className="text-2xl sm:text-4xl lg:text-5xl xl:text-6xl sm:px-[15%] md:px-[15%] lg:mx-14 lg:px-[7%] xl:px-[15%] font-medium text-rose-500 text-center">
            Bug (Issue) tracking app at your fingertips
            </h1>
            <p className="mt-8 text-lg text-center text-yellow-50">
            A simple, fast and scalable bug tracking system that helps you manage bugs easily and deliver great products on time. 
            Submit, track and fix your bugs faster in our free bug tracking tool with the help of custom workflows & business rules.
            </p>
    
          </motion.div>
          <br/>

          {/* ACTIONS */}
          <motion.div
            className="mt-8 flex items-center gap-8"
            initial="hidden"
            whileInView="visible"
            viewport={{ once: true, amount: 0.5 }}
            transition={{ delay: 0.2, duration: 0.5 }}
            variants={{
              hidden: { opacity: 0, x: -50 },
              visible: { opacity: 1, x: 0 },
            }}
          >
            <div className="h-40 w-40 align-middle">
                <img alt="logo" src={giphy} />
              </div>
            <button className="rounded-md hover:bg-primary-200 px-10 py-2 bg-purple-300 hover:text-white align-middle">
              <Link to="/login" className="text-black text-xl">
                ByeBug
              </Link>
            </button>
            <div className="h-40 w-40 align-middle">
                <img alt="logo" src={giphy} />
              </div>

          </motion.div>
        </div>
              <br/>
        {/* video */}
        <div
          className="flex basis-3/5 justify-center md:z-10
              md:ml-40 md:mt-16 md:justify-items-end "
        >
          {/*<video src={video} autoPlay loop muted /> */}
          <img alt="home-pageGraphic" src={bug} />
        </div>
      </motion.div>
    </section>
  );
};

export default Home;
